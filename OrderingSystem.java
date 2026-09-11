 
 
 
import java.util.Scanner; 
 
public class OrderingSystem { 
 
    public static void main(String[] args) { 
 
        Scanner input = new Scanner(System.in); 
 
        String[] items = { 
            "Burger", 
            "Pizza", 
            "Kerrimo", 
            "Sandwich", 
            "Iced Tea" 
        }; 
 
        double[] prices = { 
            60.00, 
            110.00, 
            180.00, 
            20.00, 
            25.00 
        }; 
 
        int totalQuantity = 0; 
        double totalBeforeDiscount = 0; 
        double totalDiscount = 0; 
 
        char orderAgain; 
 
        System.out.println("======== CANTEEN ORDERING SYSTEM ========"); 
 
        do { 
 
            System.out.println("\nAvailable Items:"); 
            for (int i = 0; i < items.length; i++) { 
                System.out.printf("%d. %-12s - PHP %.2f%n", 
                        i + 1, items[i], prices[i]); 
            } 
 
            System.out.print("\nEnter item number: "); 
            int itemNumber = input.nextInt(); 
 
            if (itemNumber < 1 || itemNumber > items.length) { 
                System.out.println( 
                    "Invalid error! Please enter a valid item." 
                ); 
 
                System.out.print("\nDo you want to order again? (Y/N): "); 
                orderAgain = input.next().charAt(0); 
                continue; 
            } 
 
            System.out.print("Enter quantity: "); 
            int quantity = input.nextInt(); 
 
            if (quantity < 1 || quantity > 10) { 
                System.out.println( 
                    "Invalid error! Please enter a valid quantity." 
                ); 
 
                System.out.print("\nDo you want to order again? (Y/N): "); 
                orderAgain = input.next().charAt(0); 
                continue; 
            } 
 
            double subtotal = prices[itemNumber - 1] * quantity; 
 
            System.out.println("\nItem: " + items[itemNumber - 1]); 
            System.out.println("Quantity: " + quantity); 
            System.out.printf("Subtotal: PHP %.2f%n", subtotal); 
 
            System.out.print("Are you a student? (Y/N): "); 
            char student = input.next().charAt(0); 
 
            double discountRate; 
 
            if (student == 'Y' || student == 'y') { 
 
                if (subtotal >= 500) { 
                    discountRate = 0.13;  
                } else { 
                    discountRate = 0.10;  
                } 
 
            } else { 
                if (subtotal >= 500) { 
                    discountRate = 0.05;  
                } else { 
                    discountRate = 0.00;  
                } 
            } 
 
            double discount = subtotal * discountRate; 
            double finalAmount = subtotal - discount; 
 
            System.out.printf("Discount: PHP %.2f%n", discount); 
            System.out.printf("Order Total: PHP %.2f%n", finalAmount); 
 
            totalQuantity += quantity; 
            totalBeforeDiscount += subtotal; 
            totalDiscount += discount; 
 
            System.out.print("\nDo you want to order again? (Y/N): "); 
            orderAgain = input.next().charAt(0); 
 
        } while (orderAgain == 'Y' || orderAgain == 'y'); 
 
        double finalAmountPayable = totalBeforeDiscount - totalDiscount; 
 
        System.out.println("\n========== ORDER SUMMARY =========="); 
        System.out.println("Total items purchased: " + totalQuantity); 
        System.out.printf("Total amount before discount: PHP %.2f%n", 
                totalBeforeDiscount); 
        System.out.printf("Total discount: PHP %.2f%n", 
                totalDiscount); 
        System.out.printf("Final amount payable: PHP %.2f%n", 
                finalAmountPayable); 
        System.out.println("Thank you for ordering!"); 
 
        input.close(); 
    } 
} 
 
 