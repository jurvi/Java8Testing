package com.jjarvela;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.Data;

import static org.junit.Assert.assertTrue;

/**
 * Created by jjarvela on 09/01/17.
 */
public class FlatMapTest {

    @Data
    private class Developer {

        private Set<String> languages = new HashSet<>();

        private String name;

        public Developer(String name) {
            this.name = name;
        }

        public void addLanguage(String language) {
            languages.add(language);
        }
    }

    @Test
    public void flatMap() {
        // Set up data
        List<Developer> developerTeam = new ArrayList<>();
        Developer oldSkoolDeveloper = new Developer("Old Skool");
        oldSkoolDeveloper.addLanguage("COBOL");
        oldSkoolDeveloper.addLanguage("FORTRAN II");
        oldSkoolDeveloper.addLanguage("LISP");
        oldSkoolDeveloper.addLanguage("BASIC");
        oldSkoolDeveloper.addLanguage("JAVA");
        Developer newAgeDeveloper = new Developer("New Age Hipster");
        newAgeDeveloper.addLanguage("SWIFT");
        newAgeDeveloper.addLanguage("CLOJURE");
        newAgeDeveloper.addLanguage("GO");
        newAgeDeveloper.addLanguage("JAVASCRIPT");
        developerTeam.add(oldSkoolDeveloper);
        developerTeam.add(newAgeDeveloper);

        // Stream all developers' languages to single Set
        Set<String> teamLanguages = developerTeam.stream().map(developer -> developer.getLanguages())
            .flatMap(languages -> languages.stream()).collect(Collectors.toSet());

        // Asserts
        assertTrue(teamLanguages.containsAll(oldSkoolDeveloper.getLanguages()));
        assertTrue(teamLanguages.containsAll(newAgeDeveloper.getLanguages()));

    }
}
