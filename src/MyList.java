import java.util.Arrays;

public class MyList <T>{
    private int capacity = 10;
    private T[] array;
    private T[] tempArray;

    public MyList(){
        this.array = (T[]) new Object[capacity];
    }

    public MyList(int capacity){
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[this.capacity];
    }

    public int size(){
        int count = 0;
        for(int i = 0; i<getCapacity(); i++){
            if(array[i] != null){
                count++;
            }
        }
        return count;
    }

    public void add(T object){
        if(size() >= getCapacity()){
            this.tempArray = this.array;
            setCapacity(getCapacity()*2);
            this.array = (T[]) new Object[getCapacity()];
            this.array = Arrays.copyOf(this.tempArray,getCapacity());
        }
        this.array[size()] = object;
    }

    public boolean isInvalidIndex(int index){
        return size() < index;
    }

    public T get(int index){
        if(isInvalidIndex(index)){
            return null;
        }
        return this.array[index];
    }

    public T remove (int index){
        if(isInvalidIndex(index)){
            return null;
        }
        T[] temp = this.array;
        this.array[index]=null;
        for(int i=index; i<size(); i++){
            if(size()-i==1){
                this.array[i]=null;
            }else{
                this.array[i]=temp[i+1];
            }
        }
        return this.array[index];
    }

    public T set(int index, T object){
        if(isInvalidIndex(index)){
            return null;
        }
        this.array[index]=object;
        System.out.println("Changing is completed!");
        return this.array[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(this.array);
    }

    public int indexOf(T object){
        for(int i=0; i<size(); i++){
            if(this.array[i]==object){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T object){
        for(int i=size()-1; i>=0; i--){
            if(this.array[i]==object){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear(){
        this.array = (T[]) new Object[getCapacity()];
    }

    public boolean contains(T object){
        if(size()==0){
            return false;
        }
       for(int i=0; i<size(); i++){
           if(this.array[i]==object){
               return true;
           }
       }
        return false;
    }

    public MyList<T> subList(int start, int finish){
        if(start>finish){
            int temp = start;
            start=finish;
            finish=temp;
        }
        MyList<T> list = new MyList<>(finish-start+1);
        for(int i=start; i<=finish; i++ ){
            list.add(this.array[i]);
        }
        return list;
    }

    public T[] toArray(){
        return this.array;
    }
}
