package peopleinfile;

public interface SaveableReadable<T> {
    public String saveToString();
    public T readFromString(String data);
}
