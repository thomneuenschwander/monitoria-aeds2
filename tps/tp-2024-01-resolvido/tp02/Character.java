package tp02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Character(
        String id,
        String name,
        List<String> alternateNames,
        String house,
        String ancestry,
        String species,
        String patronus,
        boolean hogwartsStaff,
        boolean hogwartsStudent,
        String actorName,
        boolean alive,
        List<String> alternateActors,
        LocalDate dateOfBirth,
        int yearOfBirth,
        String eyeColour,
        String gender,
        String hairColour,
        boolean wizard) implements Comparable<Character> {

    public Character {
        alternateNames = alternateNames != null ? alternateNames : List.of();
        alternateActors = alternateActors != null ? alternateActors : List.of();
    }

    @Override
    public int compareTo(Character o) {
        return this.id.compareTo(o.id);
    }

    public static Map<String, Character> readFromCSV(String csvFilePath) {
        Map<String, Character> characters = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine();
            while (br.ready()) {
                String csvLine = br.readLine();
                Character character = parseLine(csvLine);
                characters.put(character.id(), character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private static Character parseLine(String csvLine) {
        String[] parts = csvLine.split(";");

        String id = parts[0];
        String name = parts[1];

        List<String> alternateNames = parts[2].isEmpty() ? List.of()
                : List.of(parts[2].replaceAll("[\\[\\]'']", "").split(","));

        String house = parts[3];
        String ancestry = parts[4];
        String species = parts[5];
        String patronus = parts[6];
        boolean hogwartsStaff = Boolean.parseBoolean(parts[7]);
        boolean hogwartsStudent = Boolean.parseBoolean(parts[8]);
        String actorName = parts[9];
        boolean alive = Boolean.parseBoolean(parts[10]);

        List<String> alternateActors = parts[11].isEmpty() ? List.of()
                : List.of(parts[11].replaceAll("[\\[\\]'']", "").split(","));

        LocalDate dateOfBirth = null;
        if (!parts[12].isEmpty()) {
            String dobStr = parts[12];
            String[] dobParts = dobStr.split("-");
            if (dobParts.length == 3 && dobParts[1].length() == 1) {
                dobStr = dobParts[0] + "-0" + dobParts[1] + "-" + dobParts[2];
            }
            dateOfBirth = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        int yearOfBirth = parts[13].isEmpty() ? 0 : Integer.parseInt(parts[13]);
        String eyeColour = parts[14];
        String gender = parts[15];
        String hairColour = parts[16];
        boolean wizard = Boolean.parseBoolean(parts[17]);

        return new Character(id, name, alternateNames, house, ancestry, species, patronus, hogwartsStaff,
                hogwartsStudent, actorName, alive, alternateActors, dateOfBirth, yearOfBirth, eyeColour,
                gender, hairColour, wizard);
    }

    @Override
    public String toString() {
        return "[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %b ## %b ## %s ## %b ## %s ## %d ## %s ## %s ## %s ## %b]"
                .formatted(id, name, alternateNames.isEmpty() ? "{}" : alternateNames, house, ancestry, species,
                        patronus,
                        hogwartsStaff, hogwartsStudent, actorName, alive, dateOfBirth != null ? dateOfBirth : "",
                        yearOfBirth, eyeColour, gender, hairColour, wizard);
    }
}
