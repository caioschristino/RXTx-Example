import gnu.io.CommPortIdentifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Enumeration;

public class SerialPortUtils {
	private static final Logger LOG = LoggerFactory.getLogger(SerialPortUtils.class);

	public static void showAvailablePorts() {
		LOG.info("Looking for serial ports");

		@SuppressWarnings("unchecked")
		Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
		if (ports == null || (ports != null && !ports.hasMoreElements())) {
			LOG.error("No serial ports found!");
		} else {
			while (ports.hasMoreElements()) {
				CommPortIdentifier port = ports.nextElement();
				LOG.info("Found port: " + port.getName());
			}
		}
	}
}



///** 
//* Read and write to a port.   
//*
//* <p>Usage:  To see what ports are available:</p>
//* <pre>
//* java -classpath $PTII:${PTII}/lib/nrjavaserial-3.11.0.jar ptolemy.actor.lib.jjs.modules.serial.test.SerialTest
//* </pre>
//*
//* <p>To connect to a port:</p>
//* <pre>
//* java -classpath $PTII:${PTII}/lib/nrjavaserial-3.11.0.jar ptolemy.actor.lib.jjs.modules.serial.test.SerialTest /dev/tty.usbserial-DA01R74U
//* </pre>
//*/
//public static void showAvailablePorts(String [] args)throws Exception{
// String port = "/dev/tty.Bluetooth-Incoming-Port";
//
// if (args.length != 1) {
//     System.err.println("Usage: java -classpath $PTII:${PTII}/lib/nrjavaserial-3.11.0.jar ptolemy.actor.lib.io.comm.SerialTest /dev/tty");
//     System.err.println("Below are the ports:");
//     // Enumerate the available ports.
//     Enumeration ports = CommPortIdentifier.getPortIdentifiers();
//     while (ports.hasMoreElements()) {
//         CommPortIdentifier identifier = (CommPortIdentifier) ports
//             .nextElement();
//         if (identifier.getPortType() == CommPortIdentifier.PORT_SERIAL) {
//             System.err.println(identifier.getName());
//         }
//     }
// } else {
//     port = args[0];
// }
//
// int baudRate = 9600;
// NRSerialPort serialPort = new NRSerialPort(port, baudRate);
// serialPort.connect();
// System.out.println("Connected to " + serialPort);
//
// DataInputStream inputStream = new DataInputStream(serialPort.getInputStream());
// DataOutputStream outputStream = new DataOutputStream(serialPort.getOutputStream());
//
// byte b = (byte)inputStream.read();
// System.out.println("Read a byte: " + b);
// outputStream.write(b);
// System.out.println("Wrote a byte: " + b);
//
// serialPort.disconnect();
// System.out.println("Called serialPort.disconnect()");
//}