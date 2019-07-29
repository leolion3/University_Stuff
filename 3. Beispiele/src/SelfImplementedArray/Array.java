package SelfImplementedArray;

@SuppressWarnings("all")
public class Array<T> {

    T[] array;

    /** Constructor */
    public Array(int length){
        array = (T[]) new Object[length];
    }

    /** This method sets the object at a specific location
     * @param id - id of the desired location
     * @param element - the element to be added to this location */
    public void set(int id,T element){
        array[id] = element;
    }

    /** This method returns the entry at a specific location
     * @param id - the id at which to return the element */
    public T get(int id){
        return array[id];
    }

    /** This method returns the length of the array
     * @return array length */
    public int length(){
        return array.length;
    }


    /** This method adds elements to the end of the array
     * @param element - the element to be added at the array's end */
    public void insert(T element){
        T[] newArray = (T[]) new Object[array.length+1];
        for(int i=0;i<array.length;i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        array = newArray.clone();
    }

    /** This method removes the element at a specific location
     * @param id - the id which's element to remove */
    public void remove(int id){
        T[] newArray = (T[]) new Object[array.length-1];
        int b=0;
        for(int i=0;i<array.length;i++){
            if(i!=id){ // Element array[id] (index) gets ignored
                newArray[b] = array[i];
                b++;
            }
        }
        array = newArray.clone();
    }

    /** This method checks if the array is empty */
    public boolean empty(){
        return array.length==0;
    }

}
