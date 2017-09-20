class LinkedList2 {

    private Element head;
    private Element tail;
    private Element curent;
    private int size;
    private int index; // Индекс текущего элемента?


    public LinkedList2() {
        this.head = new Element(null, null, null);
        this.tail = this.head;
        curent = tail;
        this.size = 0;
        this.index = 0;

    }

    public int getSize() {
        return size;
    }

    public void add(Object el) {
        this.size++;
        Element newElement = new Element (el, tail, null);
        tail.next = newElement;
        tail = newElement;
        if (size == 1) head.next = tail;
    }

    public void addFirst(Object el) {
        this.size++;
        head.next = new Element(el, head, head.next);

    }

    public void removeFirst() {
        this.size--;
        Element el = head.next;
        head.next = el.next;
    }

    public void  removeLast() {
        this.size--;
        tail = tail.prev;
    }

    public Object getFirst() {
        curent = head.next;
        return head.next.element;
    }

    public Object getLast() {
        curent = tail;
        return tail.element;

    }

    public Object get (int index) {
        if (index > size | index < 1 ) throw new IllegalArgumentException();

        if (index < (size>>1)) {
            curent = head;
            for (int i = 1; i <=index ; i++) {
                next();
            }
            return get();
        } else {
            curent = tail;
            for (int i = size ; i > index; i--) {
                curent = curent.prev;
            }
            return curent.element;

        }
    }

    public Object get() {
        return curent.element;
    }

    public Object next () {
        curent = curent.next;
        return curent.element;
    }

    public boolean contais (Object el) {
        Element cur = head.next;
        for (int i = 1; i <= size ; i++) {
            if (cur.element.equals(el)) return true;
            cur = cur.next;
        }
        return false;
    }



    class Element {
        Object element;
        Element prev;
        Element next;

        Element(Object element, Element prev, Element next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }
    }

}

class Test {
    public static void main(String[] args) {
        LinkedList2 list2 = new LinkedList2();
        list2.add(15);
        list2.add(14);
        list2.add(16);
        list2.add(18);
        list2.add(17);
        System.out.println("List size:" + list2.getSize());
        System.out.println(list2.getFirst());
        System.out.println(list2.getLast());

        System.out.println("Ищем элемент 15 в списке: " + list2.contais(15));
        System.out.println("Ищем элемент 20 в списке: " + list2.contais(20));

        System.out.println("Добавляем  первый  элемент.");
        list2.addFirst(30);
        System.out.println(list2.getFirst());

        System.out.println("Удаляем первый и последний");
        list2.removeFirst();
        list2.removeLast();
        System.out.println("Первый элемент: " + list2.getFirst());
        System.out.println("Второй элемент: " + list2.next());
        System.out.println("Последний элемент: " + list2.getLast());

        System.out.println("Возвращаем 1й элемент: " + list2.get(1));
        System.out.println("Возвращаем 2й элемент: " + list2.get(2));
        System.out.println("Возвращаем 3й элемент: " + list2.get(3));
        System.out.println("Возвращаем 4й элемент: " + list2.get(4));




    }
}
