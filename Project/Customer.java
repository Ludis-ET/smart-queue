package Project;

public abstract class Customer {
    private String name;
    private int tokenNumber;
    private long arrivalTime;

    public Customer(String name, int tokenNumber) {
        this.name = name;
        this.tokenNumber = tokenNumber;
        this.arrivalTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public abstract int getPriority();
}

class RegularCustomer extends Customer {
    public RegularCustomer(String name, int tokenNumber) {
        super(name, tokenNumber);
    }

    @Override
    public int getPriority() {
        return 3;
    }
}

class VIPCustomer extends Customer {
    public VIPCustomer(String name, int tokenNumber) {
        super(name, tokenNumber);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}

class SeniorCustomer extends Customer {
    public SeniorCustomer(String name, int tokenNumber) {
        super(name, tokenNumber);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
