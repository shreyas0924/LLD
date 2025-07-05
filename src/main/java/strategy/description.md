
---

# Strategy Pattern in Java

##  Overview

The **Strategy Pattern** is a **behavioral design pattern** that enables selecting an algorithm's behavior at runtime. It defines a family of algorithms, encapsulates each one, and makes them interchangeable.

> It helps **avoid conditional statements** by delegating behavior to strategy classes.

---

##  Real-World Analogy

Imagine a **navigation app** (like Google Maps) where you can choose how you want to travel: by **car**, **bike**, or **walking**. Each of these travel modes is a strategy. You can switch between them without modifying the core app logic.

---

##  Components of the Pattern

1. **Strategy Interface** – declares a method for the algorithm.
2. **Concrete Strategies** – implement the algorithm using different approaches.
3. **Context Class** – is configured with a strategy object and delegates the behavior to the strategy.

---

##  Java Implementation Example

### 1. Define the Strategy Interface

```java
public interface PaymentStrategy {
    void pay(int amount);
}
```

---

### 2. Create Concrete Strategy Classes

```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
```

---

### 3. Create the Context Class

```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}
```

---

### 4. Usage

```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(200);
    }
}
```

---

##  Benefits

* **Open/Closed Principle**: New strategies can be added without modifying existing code.
* **Eliminates Conditional Logic**: Removes if-else or switch-case for algorithm selection.
* **Code Reuse**: Strategies can be reused across contexts.

---

##  When to Use

* When you have multiple related algorithms or behaviors.
* When you want to avoid long `if-else` chains.
* When your classes have multiple behaviors that can be selected dynamically.

---

##  Strategy Pattern vs. State Pattern

| Strategy Pattern                       | State Pattern                             |
| -------------------------------------- | ----------------------------------------- |
| Focuses on **how a task is performed** | Focuses on **what state an object is in** |
| Client selects the strategy            | Context controls the state transition     |

---

## Summary

The **Strategy Pattern** allows the behavior of a class to be selected at runtime. It is ideal for scenarios where multiple algorithms exist for a task, and the decision on which to use can vary based on input or context.

---

