public class App {
    public static void main(String[] args) {

        TelevisionViewer tvViewer = new TelevisionViewer();
        tvViewer.watchTelevision(10);

    }
}

class Television {
    private int channel = 1;

    public void nextChannel() {
        if (channel < 10) {
            channel++;
        } else {
            channel = 1;
        }
    }

    public int getCurrentChannel() {
        return channel;
    }
}

class TelevisionViewer {
    public void watchTelevision(int days) {
        Television tv = new Television();
        for (int day = 1; day <= days; day++) {
            int channelsToWatch = 0;
            if (day == 1) {
                channelsToWatch = 3;
            } else if (day % 2 == 0) {
                channelsToWatch = 4;
            } else {
                channelsToWatch = 6;
            }
            System.out.println("Woke up, day " + day);
            for (int i = 0; i < channelsToWatch; i++) {
                System.out.println("Watching channel " + tv.getCurrentChannel());
                tv.nextChannel();
            }
            System.out.println("Falling asleep\n");
        }
    }
}
