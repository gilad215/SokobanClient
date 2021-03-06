package controller;

import model.data.Command;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Controller  {
    private BlockingQueue<Command> queue;
    private boolean isStopped = false;

    public Controller() {
        queue = new ArrayBlockingQueue<Command>(50);
    }

    public void insertCommand(Command command) {
        try {
            queue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isStopped) {
                    try {
                        Command cmd = queue.poll(1, TimeUnit.SECONDS);
                        if (cmd != null)
							try {
								cmd.execute();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
    }

    public void stop() {
        isStopped = true;
    }

}
