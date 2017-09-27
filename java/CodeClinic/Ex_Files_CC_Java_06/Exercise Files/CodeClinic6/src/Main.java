import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		List<ArrayList<String>> csv = main.parseCSV(0);
		Document doc = Jsoup.parse(
				new File("Files/programs/graphic-design.htm"), "UTF-8");
		doc = main.modifyHTML(doc, csv, 0);
		csv = main.parseCSV(1);
		doc = main.modifyHTML(doc, csv, 1);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("Files/programs/new-graphic-design.htm"),
				"UTF-8"));
		writer.write(doc.toString());
		writer.close();
	}

	public List<ArrayList<String>> parseCSV(int index)
			throws FileNotFoundException {
		Scanner scanner;
		switch (index) {
			case 0: scanner = new Scanner(new File("Files/_assets/first_semester.csv"));
			break;
			case 1: scanner = new Scanner(new File("Files/_assets/second_semester.csv"));
			break;
			default: throw new FileNotFoundException();
		}
		scanner.useDelimiter("\r|,");
		List<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();
		int i = 0;
		while (scanner.hasNext()) {
			if (i / 2 == i / 2.0)
				csv.add(new ArrayList<String>());
			csv.get(i / 2).add(scanner.next());
			i++;
		}
		scanner.close();
		return csv;
	}

	public Document modifyHTML(Document doc, List<ArrayList<String>> csv,
			int index) throws IOException {
		Element table = doc.select("table").get(index);
		for (int i = 0; i < csv.size(); i++) {
			table.appendElement("tr");
			if (i == 0) {
				table.select("tr").get(i).appendElement("th")
						.text(csv.get(i).get(0));
				table.select("tr").get(i).appendElement("th")
						.text(csv.get(i).get(1));
			} else {
				Element e = table.select("tr").get(i).appendElement("td");
				String[] s = csv.get(i).get(0).split(" ", 2);
				e.text(" " + s[1]);
				e.prependElement("strong");
				e.select("strong").first().text(s[0]);
				table.select("tr").get(i).appendElement("td")
						.text(csv.get(i).get(1));
			}

		}
		return doc;
	}
}
