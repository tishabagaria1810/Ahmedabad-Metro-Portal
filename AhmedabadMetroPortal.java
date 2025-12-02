import java.util.*;

class AhmedabadMetroPortal 
{
    static 
	{
		String purple="\u001B[35m";
		String cyan="\u001B[36m";
		System.out.println("\n-*-*-*- In this project, we have used the following concept's of JAVA -*-*-*-");
		System.out.println("\n1) Constructor and methods");
		System.out.println("2) Control statements (such as Loops, Conditional Statements");
		System.out.println("3) Input validation");
		System.out.println("4) Static block");
		System.out.println(purple+"\n\n     *****************************************");
        System.out.println("     *  Welcome to Ahmedabad Metro Portal!!  *");
		System.out.println("     *****************************************");
		System.out.println(cyan+"\n:::::::: Let's first enter all your details ::::::::");
	}
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        MetroPortal portal = new MetroPortal();
		String white="\u001B[37m";
        String passengerName = null;
		String firstName=null;
		String secondName=null;
		String mobileNo=null;
		int count=0;
		boolean b=true;
		boolean b2=true;
		boolean b1=true;
		do
		{
			System.out.print(white+"\nEnter your First name : ");
			firstName = sc.nextLine();
			for(int i=0;i<firstName.length();i++)
			{
				if(((firstName.charAt(i)>='a') && (firstName.charAt(i)<='z')) || ((firstName.charAt(i)>='A') && (firstName.charAt(i)<='Z' )))
				{
					if ((i==firstName.length()-1))
					{
						b=false;
					}
					continue;
				}
				else
				{
					System.out.println("Please enter your First name correctly!!");
					break;
				}
			}
		}while(b);
		do
		{
			System.out.print("Enter your Last name : ");
			secondName = sc.nextLine();
			for(int i=0;i<secondName.length();i++)
			{
				if(((secondName.charAt(i)>='a') && (secondName.charAt(i)<='z')) || ((secondName.charAt(i)>='A') && (secondName.charAt(i)<='Z' )))
				{
					if ((i==secondName.length()-1))
					{
						b2=false;
					}
					continue;
				}
				else
				{
					System.out.println("Please enter your Second name correctly!!");
					break;
				}
			}
		}while(b2);
		passengerName=firstName+" "+secondName;
        portal.setPassengerName(passengerName);
		
		boolean number=true;
		do
		{
			System.out.print("Enter your mobile Number : ");
			mobileNo=sc.nextLine();
			for(int i=0;i<mobileNo.length();i++) 
					{
						if(mobileNo.charAt(i)>='0' && mobileNo.charAt(i)<='9') 
						{
							number=true;
						}
						else
						{
							number=false;
							break;
						}
					}
					if(mobileNo.length()==10 && number==true) 
					{
						b1=false;
					}
					else 
					{
						System.out.println("Invalid mobile number!!");
					}
		}while(b1);
		portal.setMobileNo(mobileNo);
        
		portal.showMenu();
    }
}


class MetroPortal 
{
    String passengerName;
	String mobileNo;
    Ticket ticket;
	Scanner sc=new Scanner(System.in);
	
	String []route1 ={"Thaltej Gam", "Thaltej", "Doordarshan Kendra", "Gurukul Road", "Gujarat University", 
                "Commerce Six Road", "Stadium", "Old High Court (Interchange)", "Shah Pur", "Gheekanta", 
                "Kalupur Railway Station", "Kankaria East", "Appareal Park", "Amraiwadi", "Rabari Colony", 
                "Vastral", "Nirant Cross Road", "Vastral Gam"};
	String []route2 = {"Motera Stadium", "Sabarmati Metro Station", "A E C", "Sabarmati Railway Station", "Ranip", 
                "Vadaj Metro Station", "Vijay Nagar Metro Station", "Usmanpura Metro Station", 
                "Old High Court (Interchange)", "Gandhigram Metro Station", "Paldi", "Shreyas", "Rajiv Nagar Metro Station", 
                "Jivraj Park", "A P M C"};
				
    void setPassengerName(String name) 
	{
        passengerName = name;
    }
	void setMobileNo(String number)
	{
		mobileNo=number;
	}

    void showMenu() 
	{
		String cyan="\u001B[36m";
		String white="\u001B[37m";
		boolean b=true;
        do 
		{
            System.out.println(cyan+"\n-*-*-*-*- Welcome to Ahmedabad Metro Portal " +passengerName+" -*-*-*-*-");
            System.out.println(white+"\n1) Booking of ticket");
            System.out.println("2) View ticket");
            System.out.println("3) Fare inquiry");
            System.out.println("4) Customer Service");
            System.out.println("5) Give Feedback");
            System.out.println("6) Exit");
            System.out.print("\n--> Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice) 
			{
                case 1:
                    bookingTicket();
                    break;
                case 2:
                    viewTicket();
                    break;
                case 3:
                    fareInquiry();
                    break;
                case 4:
                    customerService();
                    break;
                case 5:
                    giveFeedback();
                    break;
                case 6:
                    System.out.println("\n===== Thank you for using Ahmedabad Metro Portal. Goodbye! =====");
                    b=false;
					break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(b);
    }

    // Booking of ticket
    void bookingTicket() 
	{
        String cyan="\u001B[36m";
		String white="\u001B[37m";
		int routeChoice = 0;
        String []selectedRoute = null;
		boolean t=true;
		do
		{
			System.out.println(cyan+"\n-*-*-*-*-*- Available Routes -*-*-*-*-*- ");
			System.out.println(white+"\n1) EW Line (Thaltej Gam to Vastral Gam)");
			System.out.println("2) NS Line (Motera Stadium to APMC)");
			System.out.print("\n--> Select Route : ");
			routeChoice = sc.nextInt();
			if (routeChoice == 1)
			{
				selectedRoute = route1;
				t=false;
			} 
			else if (routeChoice == 2) 
			{
				selectedRoute = route2;
				t=false;
			} 
			else 
			{
				System.out.println("No such route exist!!");
			}
		}while(t);
		
        // Display route destinations
		System.out.println(cyan+"\n-*-*- Here are destinations of your selected route -*-*-\n");
        for (int i = 0; i < selectedRoute.length; i++) 
		{
			System.out.println(white+(i + 1) + ") " + selectedRoute[i]);
		}
		
		int startStop = 0;
		int endStop = 0;
		boolean tf=true;
		do
		{
			System.out.print("\nEnter boarding point number : ");
			startStop = sc.nextInt() - 1;
			System.out.print("Enter the destination point number : ");
			endStop = sc.nextInt() - 1;
			if(startStop!=endStop && startStop>=0 && endStop>=0)
			{
				tf=false;
			}
			else
			{
				System.out.println("The stops must be in between the above route ranges and also Start stop and End stop should not be equal!!");
			}
		}while(tf);
		
		int passengers=0;
        boolean b=true;
		do
		{
			System.out.print("Enter the number of passengers: ");
			passengers = sc.nextInt();
			sc.nextLine();
			if(passengers>0)
			{
				b=false;
			}
			else if(passengers==0)
			{
				System.out.println("Passengers cannot be zero!!");
			}
			else if(passengers<0)
			{
				System.out.println("Passengers cannot be negative!!");
			}
		}while(b);
		
		int fare = calculateFare(selectedRoute, startStop, endStop);
        int finalFare = fare*passengers;
		
		boolean b1=true;
		do
		{
			System.out.print("Do you want to book a return journey?(yes/no) : ");
			String returnJourney = sc.nextLine();
			if (returnJourney.equalsIgnoreCase("yes")) 
			{
				finalFare += calculateFare(selectedRoute, endStop, startStop);  
				b1=false;
			}
			else if(returnJourney.equalsIgnoreCase("no"))
			{
				System.out.println();
				b1=false;
			}
			else
			{
				System.out.println("Please enter valid input!!");
			}
		}while(b1);
		System.out.println("\nYour Ticket final fare is "+finalFare+"/-\n");
		
		// Ask for payment method
		String paymentMethod = null;
		String upiID = null;
		String cardNumber = null;
		boolean number=false;
		boolean b2=true;
		do
		{
			System.out.print("Select payment method(Card/UPI) : ");
			paymentMethod = sc.nextLine();
        
			if (paymentMethod.equalsIgnoreCase("Card"))
			{
				boolean b4=true;
				do
				{
					b2=false;
					b4=true;
					System.out.print("Enter your 12-digit credit card number : ");
					cardNumber = sc.nextLine();
					for(int i=0;i<cardNumber.length();i++) 
					{
						if(cardNumber.charAt(i)>='0' && cardNumber.charAt(i)<='9') 
						{
							number=true;
						}
						else
						{
							number=false;
							break;
						}
					}
					if(cardNumber.length()==12 && number==true) 
					{
						b4=false;
					}
					else 
					{
						System.out.println("Invalid credit card number!!");
					}
				}while(b4);
			} 
			else if (paymentMethod.equalsIgnoreCase("UPI")) 
			{
				b2=false;
				boolean b3=true;
				do
				{
					System.out.print("Enter UPI ID (must end with @oksbi and the length should be 10): ");
					upiID = sc.nextLine();
					if (!upiID.endsWith("@oksbi") || upiID.length() < 10) 
					{
						System.out.println("Invalid UPI ID\nThe UPI must ends with @oksbi and it's length has to be atleast 10 digit.");
					}
					else 
					{
						b3=false;
					}
				}while(b3);
				
			} 
			else 
			{
				System.out.println("Invalid payment method.");
			}
		}while(b2);

        // Create and store the ticket
		ticket = new Ticket(passengerName, selectedRoute[startStop], selectedRoute[endStop], finalFare, paymentMethod, passengers, mobileNo);
        System.out.println("\nYour ticket is booked successfully!\n");
        System.out.println(ticket.generatePaymentReceipt());
    }

    // View ticket
    void viewTicket() 
	{
		if (ticket == null) 
		{
            System.out.println("\nPlease book the ticket first.");
        } 
		else 
		{
            System.out.println(ticket.generateTicket());
        }
    }

    // Fare inquiry
    void fareInquiry() 
	{
        String cyan="\u001B[36m";
		String white="\u001B[37m";
		int routeChoice = 0;
        String []selectedRoute = null;
		boolean t=true;
		do
		{
			System.out.println(cyan+"\nSelect Route for Fare Inquiry : ");
			System.out.println(white+"\n1) EW Line (Thaltej Gam to Vastral Gam)");
			System.out.println("2) NS Line (Motera Stadium to APMC)");
			System.out.print("\n--> Select Route : ");
			routeChoice = sc.nextInt();
			if (routeChoice == 1)
			{
				selectedRoute = route1;
				t=false;
			} 
			else if (routeChoice == 2) 
			{
				selectedRoute = route2;
				t=false;
			} 
			else 
			{
				System.out.println("No such route exist!!");
			}
		}while(t);
		
        // Display route destinations
		System.out.println(cyan+"\n-*-*- Here are destinations of your selected route -*-*-\n");
        for (int i = 0; i < selectedRoute.length; i++) 
		{
			System.out.println(white+(i + 1) + ") " + selectedRoute[i]);
		}
		
		int startStop = 0;
		int endStop = 0;
		boolean tf=true;
		do
		{
			System.out.print("\nEnter boarding point number : ");
			startStop = sc.nextInt() - 1;
			System.out.print("Enter the destination point number : ");
			endStop = sc.nextInt() - 1;
			if(startStop!=endStop && startStop>=0 && endStop>=0)
			{
				tf=false;
			}
			else
			{
				System.out.println("The stops must be in between the above route ranges and also Start stop and End stop should not be equal!!");
			}
		}while(tf);
		
		int fare = calculateFare(selectedRoute, startStop, endStop);
        System.out.println("\nThe fare for your journey is " +fare+"/-");
    }

    // Customer service contact
    void customerService() 
	{
        System.out.println("\nContact our Customer Service:");
        System.out.println("Email: metrocustomercare@gmail.com");
        System.out.println("Phone: +91 7922960123");
    }

    // Collect feedback
    void giveFeedback() 
	{
        System.out.print("\nPlease provide your feedback: ");
		sc.nextLine();
        String feedback = sc.nextLine();
        System.out.println("Thank you for your feedback!!");
    }

    // Calculate fare
    int calculateFare(String[] selectedRoute, int startStop, int endStop) 
	{
        int distance = Math.abs(endStop - startStop);
        return 5 + (distance / 3) * 5;  
    }
}

class Ticket 
{
    String passengerName;
    String startStop;
    String endStop;
    int fare;
    String paymentMethod;
    int passengers;
	String mobile_no;

    Ticket(String passengerName, String startStop, String endStop, int fare, String paymentMethod, int passengers, String mobile_no) 
	{
        this.passengerName = passengerName;
        this.startStop = startStop;
        this.endStop = endStop;
        this.fare = fare;
        this.paymentMethod = paymentMethod;
        this.passengers = passengers;
		this.mobile_no = mobile_no;
    }

    // Generate ticket details
    String generateTicket() 
	{
        return "\n========= Ticket Details : =========\n" +
               "Passenger Name : " + passengerName +
               "\nBoarding point : " + startStop + 
               "\nDestination point : " + endStop + 
               "\nFare : " + fare +"/-"+
               "\nPayment Method : " + paymentMethod.toLowerCase() + 
               "\nNumber of Passengers : " + passengers +
			   "\n====================================";
    }

    // Generate payment receipt
    String generatePaymentReceipt()
	{
        return "\n========== Payment Receipt:==========\n\n" +  
               "Thank you for approaching us!\n\n" +
               "Payment Method : " + paymentMethod.toLowerCase() + 
			   "\nMobile no. : "+ mobile_no + 
               "\nBoarding point : " + startStop + 
               "\nDestination point : " + endStop + 
               "\nPayment Successful" +
			   "\n\n=====================================";
    }
}