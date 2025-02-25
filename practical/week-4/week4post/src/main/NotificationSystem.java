package main;

import java.util.ArrayList;
import java.util.List;

// === Template Method Pattern ===
// Abstract class for notification (Template Method)
abstract class Notification {
    public final void sendNotification(String message) {
        prepareNotification();
        send(message);
        logNotification();
    }

    protected void prepareNotification() {
        System.out.println("Preparing notification...");
    }

    protected abstract void send(String message);

    protected void logNotification() {
        System.out.println("Notification sent successfully.\n");
    }
}

// Concrete Email Notification
class EmailNotification extends Notification {
    protected void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Concrete SMS Notification
class SMSNotification extends Notification {
    protected void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Concrete Push Notification
class PushNotification extends Notification {
    protected void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// === Dependency Injection Pattern ===
// Notifier class with dependency injection
class Notifier {
    private final Notification notification;

    public Notifier(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(String message) {
        notification.sendNotification(message);
    }
}

// === Observer Pattern ===
// Observer interface for user events
interface UserEventListener {
    void onUserEvent(String event);
}

// Subject class for user events
class UserEventManager {
    private final List<UserEventListener> listeners = new ArrayList<>();

    public void addListener(UserEventListener listener) {
        listeners.add(listener);
    }

    public void notifyEvent(String event) {
        System.out.println("\nUser Event Triggered: " + event);
        for (UserEventListener listener : listeners) {
            listener.onUserEvent(event);
        }
    }
}

// Concrete observer for email notifications
class EmailEventListener implements UserEventListener {
    private final Notifier notifier;

    public EmailEventListener(Notifier notifier) {
        this.notifier = notifier;
    }

    public void onUserEvent(String event) {
        notifier.notifyUser("Email Notification for Event: " + event);
    }
}

// Concrete observer for SMS notifications
class SMSEventListener implements UserEventListener {
    private final Notifier notifier;

    public SMSEventListener(Notifier notifier) {
        this.notifier = notifier;
    }

    public void onUserEvent(String event) {
        notifier.notifyUser("SMS Notification for Event: " + event);
    }
}

// Concrete observer for push notifications
class PushEventListener implements UserEventListener {
    private final Notifier notifier;

    public PushEventListener(Notifier notifier) {
        this.notifier = notifier;
    }

    public void onUserEvent(String event) {
        notifier.notifyUser("Push Notification for Event: " + event);
    }
}

// === Main Class ===
public class NotificationSystem {
    public static void main(String[] args) {
        // Create notification services
        Notifier emailNotifier = new Notifier(new EmailNotification());
        Notifier smsNotifier = new Notifier(new SMSNotification());
        Notifier pushNotifier = new Notifier(new PushNotification());

        // Create user event manager
        UserEventManager userEventManager = new UserEventManager();

        // Register observers for different notification types
        userEventManager.addListener(new EmailEventListener(emailNotifier));
        userEventManager.addListener(new SMSEventListener(smsNotifier));
        userEventManager.addListener(new PushEventListener(pushNotifier));

        // Simulate user events
        userEventManager.notifyEvent("User Registered");
        userEventManager.notifyEvent("Password Reset");
    }
}

