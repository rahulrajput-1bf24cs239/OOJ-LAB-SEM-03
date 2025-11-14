package SEE;
import CIE.Personal;
public class External extends Personal {
    public int seeMarks[] = new int[5];

    public External(String usn, String name, int sem, int see[]) {
        super(usn, name, sem);

        for (int i = 0; i < 5; i++) {
            this.seeMarks[i] = see[i];
        }
}
}