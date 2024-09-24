package tp02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Character implements Cloneable, Comparable<Character> {
    private String id;
    private String name;
    private List<String> alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwartsStudent;
    private String actorName;
    private boolean alive;
    private List<String> alternateActors;
    private LocalDate dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    public Character() {
        this.alternateNames = new ArrayList<>();
        this.alternateActors = new ArrayList<>();
    }

    public Character(String id, String name, List<String> alternateNames, String house, String ancestry, String species,
            String patronus, boolean hogwartsStaff, boolean hogwartsStudent, String actorName, boolean alive,
            List<String> alternateActors, LocalDate dateOfBirth, int yearOfBirth, String eyeColour, String gender,
            String hairColour, boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternateNames = alternateNames;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.alternateActors = alternateActors;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public boolean isHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<String> getAlternateActors() {
        return alternateActors;
    }

    public void setAlternateActors(List<String> alternateActors) {
        this.alternateActors = alternateActors;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public boolean isWizard() {
        return wizard;
    }

    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[")
                .append(id).append(" ## ")
                .append(name).append(" ## ");

        if (alternateNames != null && !alternateNames.isEmpty()) {
            sb.append("{");
            sb.append(String.join(", ", alternateNames));
            sb.append("}");
        } else {
            sb.append("{}");
        }

        sb.append(" ## ")
                .append(house).append(" ## ")
                .append(ancestry).append(" ## ")
                .append(species).append(" ## ")
                .append(patronus).append(" ## ")
                .append(hogwartsStaff).append(" ## ")
                .append(hogwartsStudent).append(" ## ")
                .append(actorName).append(" ## ")
                .append(alive).append(" ## ")
                .append(dateOfBirth != null ? dateOfBirth.toString() : "").append(" ## ")
                .append(yearOfBirth).append(" ## ")
                .append(eyeColour).append(" ## ")
                .append(gender).append(" ## ")
                .append(hairColour).append(" ## ")
                .append(wizard)
                .append("]");

        return sb.toString();
    }

    @Override
    public int compareTo(Character o) {
        return this.getId().compareTo(o.getId());
    }

    public static List<Character> readFromCSV(String csvFilePath) {
        List<Character> characters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine();
            while (br.ready()) {
                String csvLine = br.readLine();
                characters.add(parseLine(csvLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private static Character parseLine(String csvLine) {
        var character = new Character();

        String[] parts = csvLine.split(";");

        character.id = parts[0];
        character.name = parts[1];

        String alternateNamesRaw = parts[2];
        if (!alternateNamesRaw.isEmpty())
            character.alternateNames = List.of(alternateNamesRaw.replaceAll("[\\[\\]'']", "").split(","));

        character.house = parts[3];
        character.ancestry = parts[4];
        character.species = parts[5];
        character.patronus = parts[6];
        character.hogwartsStaff = Boolean.parseBoolean(parts[7]);
        character.hogwartsStudent = Boolean.parseBoolean(parts[8]);
        character.actorName = parts[9];
        character.alive = Boolean.parseBoolean(parts[10]);

        String dobStr = parts[12];
        if (!dobStr.isEmpty()) {
            String[] dobParts = dobStr.split("-");
            if (parts.length == 3) {

                String month = dobParts[1];
                if (month.length() == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(dobParts[0]).append("-").append("0").append(month).append("-").append(dobParts[2]);
                    dobStr = sb.toString();
                }

                character.dateOfBirth = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }

        character.yearOfBirth = Integer.parseInt(parts[13]);
        character.eyeColour = parts[14];
        character.gender = parts[15];
        character.hairColour = parts[16];
        character.wizard = Boolean.parseBoolean(parts[17]);

        return character;
    }
}