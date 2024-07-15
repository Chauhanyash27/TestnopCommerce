package Pages.nopCommerce;

public enum SubCategories {
    Desktops("Desktops"),
    Notebooks("Notebooks"),
    Software("Software"),
    Cameraphoto("Camera & photo"),
    Cellphones("Cell phones"),
    Others("Others"),
    Shoes("Shoes"),
    Clothing("Clothing"),
    Accessories("Accessories");

    public String subCategories;
    SubCategories(String subCategories){
        this.subCategories = subCategories;
    }

    public String getSubCategories() {
        return subCategories;
    }
}
