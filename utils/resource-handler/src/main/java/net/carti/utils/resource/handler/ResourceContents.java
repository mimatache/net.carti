package net.carti.utils.resource.handler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Contents of a read file. Helps with returning the contents in the desired format
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 7/9/2019
 */
public class ResourceContents {

    //Instance variables
    private final InputStream stream;

    //Constructors
    private ResourceContents(InputStream stream) {
        this.stream = stream;
    }

    //Methods
    static ResourceContents fromInputStream(InputStream resourceAsStream) {
        return new ResourceContents(resourceAsStream);
    }

    /**
     * Reruns the content as a string in the UTF-8 charset
     * @return contents of the file as a string
     */
    public String asString(){
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (stream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textBuilder.toString();
    }

    /**
     * Returns the contents of the file as a String and formats it to add the given arguments
     * @param args
     *         Arguments referenced by the format specifiers in the format
     *         string.  If there are more arguments than format specifiers, the
     *         extra arguments are ignored.  The number of arguments is
     *         variable and may be zero.  The maximum number of arguments is
     *         limited by the maximum dimension of a Java array as defined by
     *         <cite>The Java&trade; Virtual Machine Specification</cite>.
     *         The behaviour on a
     *         {@code null} argument depends on the <a
     *         href="../util/Formatter.html#syntax">conversion</a>.
     * @return formatted contents
     */
    public String asFormattedString(String... args){
        return String.format(asString(), (Object[]) args);
    }

    /**
     * Reruns the content as a string in the specified charset
     * @param charset desired charset
     * @return contents
     */


    /**
     * Returns the contents as an InputStream
     * @return contents
     */
    public InputStream asInputStream(){
        return this.stream;
    }



}
