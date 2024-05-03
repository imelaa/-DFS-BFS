public class Queue {
    int input, output, size;
    int Q[] = new int[100];

    public Queue(int s) {
        size = s;
        input = 0;
        output = 0;
    }

    public void insert(int data) {
        if (isFull() == 1)
            return;
        Q[input] = data;
        input++;
    }

    public int extract() {
        if (isEmpty() == 1)
            return -1;
        int x;
        x = Q[output];
        output++;
        return(x);

    }

    public int isEmpty() {
        return (input == output) ? 1 : 0;
    }

    public int isFull() {
        return (input == size) ? 1 : 0;
    }

    public void show() {
        if (isEmpty() == 1)
            return;
        for (int i = output; i < input; i++) {
            System.out.print(Q[i] + " ");
        }
        System.out.println();
    }
}
