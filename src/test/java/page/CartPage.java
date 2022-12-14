package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private static final SelenideElement heading = $(".title");

    private static final ElementsCollection quantity = $$("input.cart_quantity");
    private static final ElementsCollection removeItem = $$(".cart_item button");
    private static final ElementsCollection cartItems = $$(".inventory_item_name");
    private static final SelenideElement removedItem = $(".removed_cart_item");
    private static final SelenideElement emptyCart = $(byText("Cart is empty!"));

    private static final SelenideElement continueShoppingButton = $("[data-test=continue-shopping]");
    private static final SelenideElement checkoutButton = $("[data-test=checkout]");

    public CartPage() {
        heading.shouldHave(text("Your Cart")).shouldBe(visible);
    }

    public void findRemovedItem() {
        removedItem.shouldBe(hidden);
    }

    public void findEmptyCartMessage() {
        emptyCart.shouldBe(visible);
    }

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage();
    }

    public ProductsPage continueShopping() {
        continueShoppingButton.click();
        return new ProductsPage();
    }

    public ItemPage enterItemPage(int index) {
        cartItems.get(index).click();
        return new ItemPage();
    }

    public void changeQuantity(int index) {
        quantity.get(index).click();
    }

    public void removeItem(int index) {
        removeItem.get(index).click();
    }
}