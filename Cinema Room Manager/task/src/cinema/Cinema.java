package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int rowsCount = getRowsCount();
        int seatsInEachRowCount = getSeatsInEachRowCount();
        String[][] cinemaRoom = fillTheMatrixOfSeats(rowsCount, seatsInEachRowCount);
        printMenu();
        int itemNumber = -1;
        while (itemNumber != 0) {
            Scanner scanner = new Scanner(System.in);
            itemNumber = scanner.nextInt();
            selectAction(itemNumber, cinemaRoom, seatsInEachRowCount, rowsCount);
            if (itemNumber != 0) {
                printMenu();
            }
        }
    }


    public static int getRowsCount() {
        System.out.print("Enter the number of rows:" + '\n' + "> ");
        Scanner scanner = new Scanner(System.in);
        int rowsCount = scanner.nextInt();
        return rowsCount;

    }

    public static int getSeatsInEachRowCount() {
        System.out.print("Enter the number of seats in each row:" + '\n' + "> ");
        Scanner scanner = new Scanner(System.in);
        int seatsInEachRowCount = scanner.nextInt();
        System.out.println();
        return seatsInEachRowCount;
    }

    public static String[][] fillTheMatrixOfSeats(int rowsCount, int seatsInEachRowCount) {
        String[][] cinemaRoom = new String[rowsCount + 1][seatsInEachRowCount + 1];
        for (int i = 0; i < rowsCount + 1; i++) {
            for (int j = 0; j < seatsInEachRowCount + 1; j++) {
                if (i == 0 && j == 0) {
                    cinemaRoom[i][j] = " ";
                } else {
                    if (j == 0) {
                        cinemaRoom[i][j] = String.valueOf(i);
                    } else if (i == 0) {
                        cinemaRoom[i][j] = String.valueOf(j);
                    } else
                        cinemaRoom[i][j] = "S";
                }
            }

        }
        return cinemaRoom;
    }

    public static void printCinema(String[][] cinemaRoom) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getRowNumber() {
        System.out.println();
        System.out.print("Enter a row number:" + '\n' + "> ");
        Scanner scanner = new Scanner(System.in);
        int rowNumber = scanner.nextInt();
        return rowNumber;
    }

    public static int getSeatNumber() {
        System.out.print("Enter a seat number in that row:" + '\n' + "> ");
        Scanner scanner = new Scanner(System.in);
        int seatNumber = scanner.nextInt();
        return seatNumber;
    }

    public static void checkInputOfTicket(int rowNumber, int seatNumber, int rowsCount, int seatsInEachRowCount,
                                          String[][] cinemaRoom) {
        if (rowNumber < 0 || seatNumber < 0 || rowNumber > rowsCount || seatNumber > seatsInEachRowCount) {
            System.out.println();
            System.out.println("Wrong input!");
        } else {
            if (isSeatBooked(rowNumber, seatNumber, cinemaRoom)) {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
            }
        }
    }


    public static boolean isSeatBooked(int rowNumber, int seatNumber, String[][] cinemaRoom) {
        if (isSeatNotValid(rowNumber, seatNumber, cinemaRoom.length - 1, cinemaRoom[0].length - 1)) {
            return false;
        } else
            return cinemaRoom[rowNumber][seatNumber] == "B";
    }

    public static boolean isSeatNotValid(int rowNumber, int seatNumber, int rowsCount, int seatsInEachRowCount) {
        return (rowNumber < 0 || seatNumber < 0 || rowNumber > rowsCount || seatNumber > seatsInEachRowCount);
    }

    public static void printPriceOfTicket(int rowNumber, int rowsCount, int seatsInEachRowCount) {
        if (rowsCount * seatsInEachRowCount <= 60) {
            System.out.println("Ticket price: " + "$10");
        } else {
            if (rowsCount % 2 == 0)
                if (rowNumber <= rowsCount / 2) {
                    System.out.println("Ticket price: " + "$10");
                } else {
                    System.out.println("Ticket price: " + "$8");
                }
            else {
                if (rowNumber <= (rowsCount - 1) / 2) {
                    System.out.println("Ticket price: " + "$10");
                } else {
                    System.out.println("Ticket price: " + "$8");
                }
            }
        }
        System.out.println();
    }

    public static int getPriceOfTicket(int rowNumber, int rowsCount, int sumOfAllSeats) {
        if (sumOfAllSeats <= 60) {
            return 10;
        } else {
            if (rowsCount % 2 == 0) {
                if (rowNumber <= (rowsCount / 2)) {
                    return 10;
                } else {
                    return 8;
                }
            } else {
                if (rowNumber <= ((rowsCount - 1) / 2)) {
                    return 10;
                } else {
                    return 8;
                }
            }
        }
    }

    public static int getSumPriceOfTickets(int sumOfAllSeats, int rowsCount, int seatsInEachRowCount) {
        System.out.println(rowsCount);
        System.out.println(seatsInEachRowCount);
        System.out.println(sumOfAllSeats);
        if (sumOfAllSeats <= 60) {
            return sumOfAllSeats * 10;
        } else {

            if (rowsCount % 2 == 0) {
                return (sumOfAllSeats / 2 * 8) + (sumOfAllSeats / 2 * 10);
            } else {
                return (((rowsCount - 1) / 2) * seatsInEachRowCount * 10) + (((rowsCount + 1) / 2) * seatsInEachRowCount * 8);

            }
        }
    }

    public static String[][] bookedTheSeat(String[][] cinemaRoom, int rowNumber, int seatNumber) {
        cinemaRoom[rowNumber][seatNumber] = "B";
        return cinemaRoom;
    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    public static void getStatistics(String[][] cinemaRoom, int rowsCount, int seatsInEachRowCount) {
        int countOfPurchasedSeats = 0;
        int sumOfAllSeats = rowsCount * seatsInEachRowCount;
        int currentIncome = 0;
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                if (cinemaRoom[i][j] == "B") {
                    countOfPurchasedSeats += 1;
                    currentIncome += getPriceOfTicket(i, rowsCount, sumOfAllSeats);
                }
            }
        }
        double percentageValueOfPurchasedSeats = ((double) countOfPurchasedSeats / (double) sumOfAllSeats * 100);
        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", countOfPurchasedSeats);
        System.out.printf("Percentage: %.2f%%%n", percentageValueOfPurchasedSeats);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", getSumPriceOfTickets(sumOfAllSeats, rowsCount, seatsInEachRowCount));
        System.out.println();
    }

    public static void selectAction(int itemNumber, String[][] cinemaRoom, int seatsInEachRowCount, int rowsCount) {
        switch (itemNumber) {
            case 1:
                printCinema(cinemaRoom);
                break;
            case 2:
                int rowNumber;
                int seatNumber;
                do {
                    rowNumber = getRowNumber();
                    seatNumber = getSeatNumber();
                    checkInputOfTicket(rowNumber, seatNumber, rowsCount, seatsInEachRowCount, cinemaRoom);
                }
                while (((isSeatBooked(rowNumber, seatNumber, cinemaRoom)) || (isSeatNotValid(rowNumber, seatNumber, rowsCount,
                        seatsInEachRowCount))));
                printPriceOfTicket(rowNumber, rowsCount, seatsInEachRowCount);
                bookedTheSeat(cinemaRoom, rowNumber, seatNumber);
                break;
            case 3:
                getStatistics(cinemaRoom, rowsCount, seatsInEachRowCount);
                break;
            case 0:
                return;
        }
    }
}
