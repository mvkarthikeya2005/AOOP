package main;

import java.util.ArrayList;
import java.util.List;

// === Observer Pattern ===
// Observer interface
interface Bidder {
    void update(String message);
}

// Concrete Bidder class
class AuctionBidder implements Bidder {
    private final String name;

    public AuctionBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    public String getName() {
        return name;
    }
}

// Subject (Observable) interface
interface Auction {
    void registerBidder(Bidder bidder);
    void removeBidder(Bidder bidder);
    void notifyBidders(String message);
}

// Concrete Auction class
class AuctionItem implements Auction {
    private final String itemName;
    private final List<Bidder> bidders = new ArrayList<>();
    private double highestBid;
    private String highestBidder;

    public AuctionItem(String itemName) {
        this.itemName = itemName;
        this.highestBid = 0.0;
        this.highestBidder = "None";
    }

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
        System.out.println(bidder + " registered for auction: " + itemName);
    }

    @Override
    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
        System.out.println(bidder + " removed from auction: " + itemName);
    }

    @Override
    public void notifyBidders(String message) {
        for (Bidder bidder : bidders) {
            bidder.update(message);
        }
    }

    public void placeBid(String bidderName, double bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidderName;
            System.out.println(bidderName + " placed a bid of $" + bidAmount);
            notifyBidders(bidderName + " is now the highest bidder with $" + bidAmount);
        } else {
            System.out.println(bidderName + "'s bid of $" + bidAmount + " is lower than the current highest bid.");
        }
    }

    public void endAuction() {
        System.out.println("\nAuction ended for item: " + itemName);
        if (!highestBidder.equals("None")) {
            notifyBidders("Auction won by " + highestBidder + " with a bid of $" + highestBid);
        } else {
            notifyBidders("No bids were placed for the auction.");
        }
    }
}

// === Template Pattern ===
// Abstract Auction Template class
abstract class AuctionTemplate {
    public final void startAuction() {
        setupAuction();
        runAuction();
        closeAuction();
    }

    protected abstract void setupAuction();
    protected abstract void runAuction();
    protected abstract void closeAuction();
}

// Concrete Auction Process class
class OnlineAuction extends AuctionTemplate {
    private final AuctionItem auctionItem;

    public OnlineAuction(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    @Override
    protected void setupAuction() {
        System.out.println("Auction setup for item: " + auctionItem);
    }

    @Override
    protected void runAuction() {
        System.out.println("Bidding started...");
    }

    @Override
    protected void closeAuction() {
        auctionItem.endAuction();
        System.out.println("Auction closed.\n");
    }
}

// === Main Class ===
public class OnlineAuctionSystem {
    public static void main(String[] args) {
        // Create auction item
        AuctionItem auctionItem = new AuctionItem("Antique Vase");

        // Create bidders
        AuctionBidder bidder1 = new AuctionBidder("Alice");
        AuctionBidder bidder2 = new AuctionBidder("Bob");
        AuctionBidder bidder3 = new AuctionBidder("Charlie");

        // Register bidders
        auctionItem.registerBidder(bidder1);
        auctionItem.registerBidder(bidder2);
        auctionItem.registerBidder(bidder3);

        // Start auction using Template Pattern
        AuctionTemplate auction = new OnlineAuction(auctionItem);
        auction.startAuction();

        // Place bids
        auctionItem.placeBid("Alice", 100);
        auctionItem.placeBid("Bob", 150);
        auctionItem.placeBid("Charlie", 200);
        auctionItem.placeBid("Alice", 250);

        // End auction
        auctionItem.endAuction();
    }
}
