import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

@Route @PageTitle("VAADIN Scrum")
public class MainView extends VerticalLayout implements RouterLayout {

    public MainView() {
        setMenuBar();
    }
    private void setMenuBar() {
        MenuBar mainMenu = new MenuBar();
        MenuItem homeMenu = mainMenu.addItem("Home");

        homeMenu.addClickListener(event -> UI.getCurrent().navigate(MainView.class));

        MenuItem gridFormsProduseMenu = mainMenu.addItem("Produse");
        SubMenu gridFormsProduseMenuBar = gridFormsProduseMenu.getSubMenu();
        gridFormsProduseMenuBar.addItem("Lista Produse...",
                event -> UI.getCurrent().navigate(ProductListView.class));
        gridFormsProduseMenuBar.addItem("Form Editare Produs...",
                event -> UI.getCurrent().navigate(ProductFormView.class));
    }
}
