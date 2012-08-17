// Copyright © 2011-2012, Esko Luontola <www.orfjackal.net>
// This software is released under the Apache License 2.0.
// The license text is at http://www.apache.org/licenses/LICENSE-2.0

package fi.jumi.actors.benchmarks;

import com.google.caliper.SimpleBenchmark;
import fi.jumi.actors.*;

import java.util.concurrent.*;

public class WarmStartupBenchmark extends SimpleBenchmark {

    private final BusyWaitBarrier barrier = new BusyWaitBarrier();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void timeMultiThreadedActors(int reps) throws Exception {
        for (int i = 0; i < reps; i++) {
            MultiThreadedActors actors = Factory.createMultiThreadedActors(executor);
            ActorThread actorThread = actors.startActorThread();

            ActorRef<Runnable> runnable = actorThread.bindActor(Runnable.class, new Runnable() {
                @Override
                public void run() {
                    barrier.trigger();
                }
            });
            runnable.tell().run();
            barrier.await();

            actorThread.stop();
        }
    }

    public void timeSingleThreadedActors(int reps) {
        for (int i = 0; i < reps; i++) {
            SingleThreadedActors actors = Factory.createSingleThreadedActors();
            ActorThread actorThread = actors.startActorThread();

            ActorRef<Runnable> runnable = actorThread.bindActor(Runnable.class, new Runnable() {
                @Override
                public void run() {
                }
            });
            runnable.tell().run();

            actors.processEventsUntilIdle();
        }
    }
}
