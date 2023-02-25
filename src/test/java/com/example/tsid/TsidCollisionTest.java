package com.example.tsid;

import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hypersistence.tsid.TSID;

public class TsidCollisionTest {

  private static final Logger sLogger = LoggerFactory.getLogger(TsidCollisionTest.class);

  @Test
  @SuppressWarnings("all")
  void testCollision() throws InterruptedException {

    TSID.Factory tsidFactory = TSID.Factory.builder()
        .withRandomFunction(TSID.Factory.THREAD_LOCAL_RANDOM_FUNCTION)
        .withNodeBits(0)
        .build();

    int threadCount = 16;
    int iterationCount = 100_000;

    AtomicInteger collisions = new AtomicInteger();

    CountDownLatch endLatch = new CountDownLatch(threadCount);

    ConcurrentMap<TSID, Integer> tsidMap = new ConcurrentHashMap<>();

    long startNanos = System.nanoTime();

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      // CHECKSTYLE:OFF
      new Thread(() -> {
        for (int j = 0; j < iterationCount; j++) {
          TSID tsid = tsidFactory.generate();

          Object oldValue = tsidMap.put(tsid, (threadId * iterationCount) + j);
          if (oldValue != null) {
            collisions.incrementAndGet();
          }
        }
        // CHECKSTYLE:ON

        endLatch.countDown();
      }).start();
    }

    sLogger.info("Starting threads");
    endLatch.await();

    sLogger.info("{} threads generated {} TSIDs in {} ms. Collisions: {}", threadCount,
        new DecimalFormat("###,###,###").format(threadCount * iterationCount),
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos), collisions.intValue());
  }

}
