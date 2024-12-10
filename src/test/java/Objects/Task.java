package Objects;

public class Task {
    private boolean isCompleted;
    private String item;

    public Task(String item, boolean isCompleted){
        this.item = item;
        this.isCompleted=isCompleted;
    }
    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}