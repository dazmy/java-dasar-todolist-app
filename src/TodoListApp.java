public class TodoListApp {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * menampilkan isi todolist
     */
    public static void showTodoList() {
        System.out.println("--- TODOLIST ---");

        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    /**
     * melakukan test untuk showTodoList()
     */
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Java OOP";

        showTodoList();
    }

    /**
     * menambahkan todo ke list
     */
    public static void addTodoList(String todo) {
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = model;
            model = new String[model.length + 10];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * melakukan test untuk addTodoList()
     */
    public static void testAddTodoList() {
        addTodoList("Makan");
        addTodoList("Ngoding");
        addTodoList("Tidur");

        for (int i = 0; i < 12; i++) {
            addTodoList("Dump ke " + (i + 1));
        }

        showTodoList();
    }

    /**
     * menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * melakukan test untuk removeTodoList()
     */
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        boolean result = removeTodoList(11);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * untuk mendapatkan input user
     * @param info
     * @return data
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * melakukan test untuk input()
     */
    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * view menampilkan isi todolist
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah TodoList");
            System.out.println("2. Hapus TodoList");
            System.out.println("x. Keluar Aplikasi");

            String input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Maaf, pilihan tidak tersedia");
            }
        }
    }

    /**
     * melakukan test untuk viewShowTodoList()
     */
    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();
    }

    /**
     * view menambahkan todo ke list
     */
    public static void viewAddTodoList() {
        System.out.println("--- TAMBAH TODOLIST ---");

        String todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal dan kembali ke showTodoList()
        } else {
            addTodoList(todo);
        }
    }

    /**
     * melakukan test untuk viewAddTodoList()
     */
    public static void testViewAddTodoList() {
        viewAddTodoList();

        showTodoList();
    }

    /**
     * view menghapus todo dari list
     */
    public static void viewRemoveTodoList() {
        System.out.println("--- HAPUS TODOLIST ---");

        String number = input("Masukkan nomor yang ingin dihapus (x jika batal)");
        if (number.equals("x")) {
            // batal dan kembali ke showTodoList()
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist ke " + number);
            }
        }
    }

    /**
     * melakukan test untuk viewRemoveTodoList()
     */
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

    // masih belum sempurna karena jika input kosong masih belum ditangani

}
