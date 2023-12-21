package ru.mirea.lab27;
import java.util.*;
//Number 1,2,3//
class HashTable {
    Map<Integer,String> hashTable = new HashMap<>();

    int hashtabHash(int key){
        return Math.abs(key) % hashTable.size();
    }

    void hashtabInit(){
        hashTable.put(0,"zero");
        hashTable.put(1,"one");
        hashTable.put(2,"two");
        hashTable.put(-1,"minus one");
        hashTable.put(-2,"minus two");
    }

    boolean hashtabAdd(int key, String value){
        int index = hashtabHash(key);

        if(hashTable.containsKey(index)){
            System.out.println("Элемент уже существует в индексе: " + index);
            return false;
        }
        hashTable.put(index,value);
        System.out.println(key + " добавлено в хэш таблицу по индексу: " +  index);
        return true;
    }

    String hashtabLookup(int key){

        int index = hashtabHash(key);
        String value = hashTable.get(index);

        if(value == null){
            System.out.println("Ключ не найден по индексу: " + index);
        }else{
            System.out.println(value);
        }

        return value;
    }

    boolean hashtabDelete(int key){

        int index = hashtabHash(key);

        if(!hashTable.containsKey(index)){
            System.out.println("Ключ не существует в индексе: " + index);
            return false;
        } else {
            hashTable.remove(index);
            System.out.println(key+ "удалено из хэш-таблицы по индексу: "+ index);
            return true;
        }
    }


    public static void main(String[] args) {

        HashTable ht = new HashTable();
        ht.hashtabInit();

        // добавление
        ht.hashtabAdd(4,"four");
        ht.hashtabAdd(-4,"minus four");

        // поиск
        String s = ht.hashtabLookup(-3);
        System.out.print(s);

        // удалиение
        boolean success = ht.hashtabDelete(-3);
        if(success){
            System.out.println("-3 deleted from hash table");
        }else {
            System.out.println("-3 doesn't exist in hash table");
        }
    }
}