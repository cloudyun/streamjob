package com.yands.stream.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

/**
 *
 * @(#)
 * @description: 速度测试工具类
 * 
 * @author: renbo
 * @date: 2015年9月10日
 * @version: V1.0
 * @modify:
 * @copyright: fhzz.
 *
 */
public class SpeedCounterUtils {
	
	private static final Logger log = Logger.getLogger(SpeedCounterUtils.class);
	
	private static Map<String, Timer> instances = new HashMap<String, Timer>();

	/**
	 * 启动速度测试
	 * 
	 * @param infoPre
	 *            打印消息的前缀
	 * @param count
	 * @param delay
	 * @param period
	 */
	public static void startCount(String infoPre, AtomicLong count, long delay, long period, AtomicLong sleep) {
		Timer timer = instances.get(infoPre);
		if (timer == null) {
			timer = new Timer();
		}
		instances.put(infoPre, timer);
		timer.schedule(new SpeedCounter(infoPre, count, sleep), delay, period);
	}

	/**
	 * 启动速度测试
	 * 
	 * @param infoPre
	 *            打印消息的前缀
	 * @param count
	 * @param delay
	 * @param period
	 */
	public static void startCount(String infoPre, AtomicLong count, long delay, long period) {
		Timer timer = instances.get(infoPre);
		if (timer == null) {
			timer = new Timer();
		}
		instances.put(infoPre, timer);
		timer.schedule(new SpeedCounter(infoPre, count, null), delay, period);
	}

	private static class SpeedCounter extends TimerTask {

		private AtomicLong count;
		private String infoStr;
		private AtomicLong sleep;

		public SpeedCounter(String infoPre, AtomicLong count, AtomicLong sleep) {
			this.count = count;
			this.infoStr = infoPre;
			this.sleep = sleep;
		}

		long start = System.currentTimeMillis();
		long now = start;

		long last = start;
		long lastCount = 0l;

		long lastOneMinitue = last;
		long lastOneMinitueCount = 0l;

		public void run() {
			now = System.currentTimeMillis();
			long newCount = count.get();
			long perCount = newCount - lastCount;

			String oneMinuteInfo = ",当前10分钟内平均数度：";
		
			if (now - lastOneMinitue >= 600000) {
				lastOneMinitue = now;
				lastOneMinitueCount = 0;

			} else {
				lastOneMinitueCount += perCount;
			}
			long tempMinitueTimespan = now - lastOneMinitue;
			long tempMinitueCount = lastOneMinitueCount;
			
			if (tempMinitueTimespan != 0) {
				oneMinuteInfo += tempMinitueCount * 1000 / tempMinitueTimespan
						+ "条/s";
			}
			else 
				oneMinuteInfo+="0条/s";

			
			long currentSpeed = perCount * 1000 / (now - last + 1);
			
			if (sleep != null) {
				if (currentSpeed > 5000l) {
					sleep.getAndAdd(200l);
				} else if (currentSpeed > 2500l) {
					sleep.getAndAdd(100l);
				} else if (currentSpeed > 2000l) {
					sleep.getAndAdd(50l);
				} else if (currentSpeed > 1500l) {
					sleep.getAndAdd(25l);
				} else if (currentSpeed < 250l) {
					long current = sleep.get() - 200l;
					sleep.set(current < 0 ? 0 : current);
				} else if (currentSpeed < 500l) {
					long current = sleep.get() - 100l;
					sleep.set(current < 0 ? 0 : current);
				} else if (currentSpeed < 1000l) {
					long current = sleep.get() - 50l;
					sleep.set(current < 0 ? 0 : current);
				} else if (currentSpeed < 1500l) {
					long current = sleep.get() - 25l;
					sleep.set(current < 0 ? 0 : current);
				}
			}
			long currentSleepp = sleep == null ? 0 : sleep.get();
			log.info("[" + infoStr + "]当前数量: " + newCount + ", 速度: " + currentSpeed + "条/s, 平均速度: " 
					+ newCount * 1000 / (now - start + 1) + "条/s" + oneMinuteInfo + " sleep : " + currentSleepp);

			last = now;
			lastCount = newCount;
		}
	}
	
	public static void cancel(String infoPre) {
		Timer timer = instances.get(infoPre);
		if (timer == null) {
			return;
		}
		timer.cancel();
	}

	public static void main(String[] args) throws InterruptedException {
		final AtomicLong count = new AtomicLong();
		final AtomicLong sleep = new AtomicLong(0);
		SpeedCounterUtils.startCount("solr插入", count, 10000, 10000, sleep);

		while (true) {
			count.addAndGet(2000l);
			Thread.sleep(500l);
			Thread.sleep(sleep.get());
		}
	}
}
