package proyecto1;


public interface ListInterface {
    public void insertBegin(InitialData element);
    public void insertFinal(InitialData element);
    public void insertInIndex(InitialData element, int index);
    public NodoDoble deleteFinal();
    public NodoDoble deleteBegin();
    public NodoDoble deleteInIndex(int index);
    public void printList();
    public boolean isEmpty();
}
