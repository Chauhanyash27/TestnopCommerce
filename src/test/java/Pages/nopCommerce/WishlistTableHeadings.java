package Pages.nopCommerce;

public enum WishlistTableHeadings {
        Addtocart("Add to cart"),
        SKU("SKU"),
        Image("Image"),
        Products("Product(s)"),
        Price("Price"),
        Qty("Qty."),
        Total("Total"),
        Remove("Remove");

        public String Headings;
        WishlistTableHeadings(String Headings){
            this.Headings = Headings;
        }

        public String getWishlistTableHeadings() {
            return Headings;
        }
}
