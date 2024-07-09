package Pages.nopCommerce;

public enum Categories {
    Computers("Computers"),
    Electronics("Electronics"),
    Apparel("Apparel"),
    Digitaldownloads("Digital downloads"),
    Books("Books"),
    Jewelry("Jewelry"),
    GiftCards("Gift Cards");

    public String categories;
    Categories(String categories){
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }
}



