package primstudios.com.shipit;

import android.graphics.Bitmap;

public class GlobalVariables {

    private static Bitmap image;
    private static String pickUpName;
    private static String pickUpFlatnumber;
    private static String pickUpApartment;
    private static String pickUpCity;
    private static String pickUpSate;
    private static String pickUpPostalCode;
    private static String pickUpContactNumber;

    private static String destinationName;
    private static String destinationFlatnumber;
    private static String destinationApartment;
    private static String destinationCity;
    private static String destinationSate;
    private static String destinationPostalCode;
    private static String destinationContactNumber;
    private static int selectedShippingOption;
    private static String itemName;
    private static String itemWeight;

    public static String getItemWeight() {
        return itemWeight;
    }

    public static void setItemWeight(String itemWeight) {
        GlobalVariables.itemWeight = itemWeight;
    }

    public static String getItemDetails() {
        return itemDetails;
    }

    public static void setItemDetails(String itemDetails) {
        GlobalVariables.itemDetails = itemDetails;
    }

    private static String itemDetails;

    public static String getPickUpName() {
        return pickUpName;
    }

    public static void setPickUpName(String pickUpName) {
        GlobalVariables.pickUpName = pickUpName;
    }

    public static String getPickUpFlatnumber() {
        return pickUpFlatnumber;
    }

    public static void setPickUpFlatnumber(String pickUpFlatnumber) {
        GlobalVariables.pickUpFlatnumber = pickUpFlatnumber;
    }

    public static String getPickUpApartment() {
        return pickUpApartment;
    }

    public static void setPickUpApartment(String pickUpApartment) {
        GlobalVariables.pickUpApartment = pickUpApartment;
    }

    public static String getPickUpCity() {
        return pickUpCity;
    }

    public static void setPickUpCity(String pickUpCity) {
        GlobalVariables.pickUpCity = pickUpCity;
    }

    public static String getPickUpSate() {
        return pickUpSate;
    }

    public static void setPickUpSate(String pickUpSate) {
        GlobalVariables.pickUpSate = pickUpSate;
    }

    public static String getPickUpPostalCode() {
        return pickUpPostalCode;
    }

    public static void setPickUpPostalCode(String pickUpPostalCode) {
        GlobalVariables.pickUpPostalCode = pickUpPostalCode;
    }

    public static String getPickUpContactNumber() {
        return pickUpContactNumber;
    }

    public static void setPickUpContactNumber(String pickUpContactNumber) {
        GlobalVariables.pickUpContactNumber = pickUpContactNumber;
    }

    public static String getDestinationName() {
        return destinationName;
    }

    public static void setDestinationName(String destinationName) {
        GlobalVariables.destinationName = destinationName;
    }

    public static String getDestinationFlatnumber() {
        return destinationFlatnumber;
    }

    public static void setDestinationFlatnumber(String destinationFlatnumber) {
        GlobalVariables.destinationFlatnumber = destinationFlatnumber;
    }

    public static String getDestinationApartment() {
        return destinationApartment;
    }

    public static void setDestinationApartment(String destinationApartment) {
        GlobalVariables.destinationApartment = destinationApartment;
    }

    public static String getDestinationCity() {
        return destinationCity;
    }

    public static void setDestinationCity(String destinationCity) {
        GlobalVariables.destinationCity = destinationCity;
    }

    public static String getDestinationSate() {
        return destinationSate;
    }

    public static void setDestinationSate(String destinationSate) {
        GlobalVariables.destinationSate = destinationSate;
    }

    public static String getDestinationPostalCode() {
        return destinationPostalCode;
    }

    public static void setDestinationPostalCode(String destinationPostalCode) {
        GlobalVariables.destinationPostalCode = destinationPostalCode;
    }

    public static String getDestinationContactNumber() {
        return destinationContactNumber;
    }

    public static void setDestinationContactNumber(String destinationContactNumber) {
        GlobalVariables.destinationContactNumber = destinationContactNumber;
    }

    public static Bitmap getImage() {
        return image;
    }

    public static void setImage(Bitmap image) {

        GlobalVariables.image = image;
    }

    public static int getSelectedShippingOption() {
        return selectedShippingOption;
    }

    public static void setSelectedShippingOption(int selectedShippingOption) {
        GlobalVariables.selectedShippingOption = selectedShippingOption;
    }

    public static String getItemName() {
        return itemName;
    }

    public static void setItemName(String itemName) {
        GlobalVariables.itemName = itemName;
    }

}