/*
 * Let's look at an example of this. 
 * We have an Item class, which represents an item on a menu.
 * An item has a name and a price.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
	String name;
	float price;
	
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return name + ": $" + price;
	}
}

class Menu {
	List<Item> menuItems;
	
	public Menu() {
		menuItems = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		menuItems.add(item);
	}
	
	public Iterator<Item> iterator() {
		return new MenuIterator();
	}
	
	class MenuIterator implements Iterator<Item> {
		int currentIndex = 0;
		@Override
		public boolean hasNext() {
			if (currentIndex >= menuItems.size()) {
				return false;
			} else {
				return true;
			}
		}
		
		@Override
		public Item next() {
			return menuItems.get(currentIndex++);
		}
		
		@Override
		public void remove() {
			menuItems.remove(--currentIndex);
		}
	}
}

public class IteratorDemo1 {
	public static void main(String[] args) {
		Item i1 = new Item("spaghetti", 7.50f);
		Item i2 = new Item("hamburger", 6.00f);
		Item i3 = new Item("chicken sandwich", 6.50f);
		
		Menu menu = new Menu();
		menu.addItem(i1);
		menu.addItem(i2);
		menu.addItem(i3);
		
		System.out.println("Displaying Menu:");
		
		Iterator<Item> iterator = menu.iterator();
		
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}
		
		/*
		 * After this, it calls remove() to remove the last item obtained by the iterator.
		 * Following this, it gets a new iterator object from the menu,
		 * and once again iterates over the menu items.
		 */
		
		System.out.println("\nRemoving last item returned");
		
		iterator.remove();
		
		System.out.println("\nDisplaying Menu:");
		
		iterator = menu.iterator();
		
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}
	}
}

//Note that since the menu utilizes a Java collection, 
//we could have used an iterator obtained for the menu list,
//rather than write our own iterator as an inner class.
