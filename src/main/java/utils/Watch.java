package utils;

import java.time.Duration;
import java.time.LocalTime;

import com.google.common.base.Stopwatch;

public class Watch {
	private static Stopwatch watch;

	public static void Start() {
		watch = Stopwatch.createStarted();
	}

	public static long Stop() {
		watch.stop();
		Duration duration = watch.elapsed();
		watch.reset();
		return duration.toMillis();		
	}
}
