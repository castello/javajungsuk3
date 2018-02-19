import java.io.*;

public class PipedReaderWriter {
	public static void main(String args[]) {
		InputThread   inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");

        //PipedReader와 PipedWriter를 연결한다.
		inThread.connect(outThread.getOutput());	

		inThread.start();
		outThread.start();
	} // main
}

class InputThread extends Thread {
	PipedReader  input = new PipedReader();
	StringWriter sw    = new StringWriter();

	InputThread(String name) {
		super(name);		// Thread(String name);
	}

	public void run() {
		try {
			int data = 0;

			while((data=input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + " received : " + sw.toString());
		} catch(IOException e) {}
	} // run

	public PipedReader getInput() {
		return input;
	}

	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch(IOException e) {}
	} // connect
}

class OutputThread extends Thread {
	PipedWriter output = new PipedWriter();

	OutputThread(String name) {
		super(name);		// Thread(String name);
	}

	public void run() {
		try {
			String msg = "Hello";
			System.out.println(getName() + " sent : " + msg);
			output.write(msg);
			output.close();
		} catch(IOException e) {}
	} // run

	public PipedWriter getOutput() {
		return output;
	}

	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch(IOException e) {}
	} // connect
}
