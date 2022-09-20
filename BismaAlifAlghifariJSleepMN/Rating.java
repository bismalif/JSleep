package BismaAlifAlghifariJSleepMN;

public class Rating
{
    private long total, count;

    public Rating() {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating){
        total += rating;
        count++;
    }

    public long getAverage() {
        if(count == 0) {
            return 0;
        }return total / count;
    }

    public long getCount(){
        return count;
    }


    public long getTotal() {
        return total;
    }

}
