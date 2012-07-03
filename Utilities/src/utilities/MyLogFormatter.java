/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;



/**
 *
 * @author Shivanth
 */
public class MyLogFormatter extends Formatter {
    public String format(LogRecord rec) {
        StringBuffer buf = new StringBuffer(1000);
        // Bold any levels >= WARNING
        
        buf.append(rec.getLevel());
        
        buf.append(':');
        //buf.append(rec.getMillis());
        buf.append(' ');
        buf.append(formatMessage(rec));
        buf.append('\n');
        return buf.toString();
    }

    // This method is called just after the handler using this
    // formatter is created
    @Override
    public String getHead(Handler h) {
        return "======================================================\nLog Generation started at :"+(new Date())+" \n======================================================\n";
    }

    // This method is called just after the handler using this
    // formatter is closed
    @Override
    public String getTail(Handler h) {
        return "======================================================\nLog Generation ended at :"+(new Date())+" \n======================================================\n";
    }
}
