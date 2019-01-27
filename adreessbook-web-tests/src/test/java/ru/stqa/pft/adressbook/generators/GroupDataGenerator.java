package ru.stqa.pft.adressbook.generators;

import ru.stqa.pft.adressbook.model.GroupData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    //Jcommander annotaition
    @Parameter(names = "-c", description = "Group count", required = true)
    public int count;

    @Parameter(names = "-f", description = "Target file", required = true)
    public String file;

    @Parameter(names = "-d", description = "Data format", required = true)
    public String format;

    public static void main (String[] args) throws IOException {

        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count); // proveriaem kakoi tip faila
        if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(groups, new File(file));
        } else {
            System.out.println("Unrecognized format");
        }
    }

    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class); // reads annotations from GroupData, we change by it tag name to 'group'
        String xml = xstream.toXML(groups);
        try (Writer writer =  new FileWriter(file)){ // Construction try helps close Writer
            writer.write(xml);
        }
    }


    private  void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private  List<GroupData> generateGroups(int count) {  //  Create groups and add them in groups array
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData()
                    .withName(String.format("test %s", i)).withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
