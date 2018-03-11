package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Javna klasa koja implementira binarno stablo u kojg dodajemo vrijednosti
 * koristeci standardni ulaz
 * 
 * @author Mihael
 *
 */
public class UniqueNumbers {

	/**
	 * Glavni program koji nam omogucuje upis podataka u stablo koristeci scanner i
	 * unos kroz standardni ulaz
	 * 
	 * @param args
	 *            - ne koristi se
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String line = new String();
			TreeNode head = null;
			int value;

			while (true) {
				System.out.println("Unesite broj>");
				if ((line = sc.nextLine()).equals("kraj")) {
					break;
				}

				try {
					value = Integer.parseInt(line);
					if (containsValue(head, value)) {
						System.out.println("Broj vec postoji. Preskacem!");
					} else {
						head = addNode(head, value);
						System.out.println("Dodano!");
					}
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("\'" + line + "\' nije cijeli broj!");
				}
			}

			System.out.println(" Ispis od najmanjeg:");
			least(head);

			System.out.println("\n Ispis od najveceg:");
			largest(head);
		} catch (Exception e) {
			System.err.println("Problemi sa scannerom!");
		}
	}

	/**
	 * Javna metoda koja dodaje vrijednost u stablo samo u slucaju ako vrijednost
	 * vec ne postoji
	 * 
	 * @param head
	 *            - referenca na trenutnu glavu
	 * @param value
	 *            vrijednost koju zelimo dodati
	 * @return referenca na glavu
	 */
	public static TreeNode addNode(TreeNode head, int value) {
		if (head == null) {
			return new TreeNode(null, null, value);
		} else if (head.value == value) {
			return head;
		} else if (head.value > value) {
			head.left = addNode(head.left, value);
		} else {
			head.right = addNode(head.right, value);
		}

		return head;
	}

	/**
	 * Privatna metoda koja ispisuje stablo od najmanjeg clana prema vecem koristeci
	 * rekurzivni inorder prolazak po stablu
	 * 
	 * @param head
	 *            - referenca na glavu
	 */
	private static void least(TreeNode head) {
		if (head == null) {
			return;
		}

		least(head.left);
		System.out.printf(" %d ", head.value);
		least(head.right);
	}

	/**
	 * Privatna metoda koja ispisuje stablo od najveceg clana prema manjem koristeci
	 * rekurzvni prolazak po stablu
	 * 
	 * @param head
	 *            - referenca na glavu
	 */
	private static void largest(TreeNode head) {
		if (head == null) {
			return;
		}

		least(head.right);
		System.out.printf(" %d ", head.value);
		largest(head.left);
	}

	/**
	 * Javna metoda koja provjerava nalazi li se vrijednost vec u stablu
	 * 
	 * @param head
	 *            - glava stabla
	 * @param value
	 *            - trazena vrijednost
	 * @return - true ako se nalazi,inace false
	 */
	public static boolean containsValue(TreeNode head, int value) {
		if (head == null) {
			return false;
		} else if (head.value == value) {
			return true;
		} else if (head.value > value) {
			containsValue(head.left, value);
		} else {
			containsValue(head.right, value);
		}

		return false;
	}

	/**
	 * Javna metoda koja rekurzivno racuna velicinu stabla
	 * 
	 * @param head
	 *            - referenca na glavu
	 * @return velicinu stabla u obliku cijelog broja
	 */
	public static int treeSize(TreeNode head) {
		if (head == null) {
			return 0;
		} else {
			return treeSize(head.left) + treeSize(head.right) + 1;
		}
	}

	/**
	 * Javna staticka klasa koja implementira clana stabla. Varijable su left i
	 * right kao reference na susjede i value kao vrijednost
	 * 
	 * @author Mihael
	 *
	 */
	public static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int value;

		/**
		 * Javni konstructor koji stvara novi list
		 * 
		 * @param left
		 *            - referenca na lijevog susjeda
		 * @param right
		 *            - referenca na desnog susjeda
		 * @param value
		 *            - vrijednost lista
		 */
		public TreeNode(TreeNode left, TreeNode right, int value) {
			// TODO Auto-generated constructor stub
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
}
