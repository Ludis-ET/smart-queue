package Project;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmartQueue {
    final private PriorityQueue<Customer> queue;
    private int tokenCounter;

    public SmartQueue() {
        queue = new PriorityQueue<>(
            Comparator.comparingInt(Customer::getPriority)
                      .thenComparingLong(Customer::getArrivalTime)
        );
        tokenCounter = 0;
    }

    public int generateToken() {
        return ++tokenCounter;
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public Customer callNext() throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("No more customers in the queue.");
        }
        return queue.poll();
    }

    public void displayQueueStatus() {
        if (queue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            System.out.println("Current Queue Status:");
            queue.forEach(customer -> 
                System.out.println("Token: " + customer.getTokenNumber() + ", Name: " + customer.getName() + ", Priority: " + customer.getPriority())
            );
        }
    }
}
