import java.util.ArrayList;

public class Mutant {
    private String[] dna;

    public Mutant(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        ArrayList<String> dnaSequences = new ArrayList<String>();

        // FILAS.
        for (String dnaSequence : dna) {
            dnaSequences.add(dnaSequence);
        }

        // COLUMNAS.
        for (int column = 0; column < dna.length; column++) {
            StringBuffer columnBuffer = new StringBuffer(dna.length);

            for (int row = 0; row < dna.length; row++) {
                columnBuffer.append(dna[row].charAt(column));
            }
            dnaSequences.add(columnBuffer.toString());
        }

        // DIAGONALES.
        for (int i = 0; i < dna.length / 2; i++) {
            StringBuffer diagonalDna1 = new StringBuffer(dna.length);
            StringBuffer diagonalDna2 = new StringBuffer(dna.length);

            for (int j = 0; j < dna.length - i; j++) {
                diagonalDna1.append(dna[j].charAt(j + i));

                if (i != 0) {
                    diagonalDna2.append(dna[i + j].charAt(j));
                }
            }

            if (diagonalDna1.length() > 0) {
                dnaSequences.add(diagonalDna1.toString());
            }

            if (diagonalDna2.length() > 0) {
                dnaSequences.add(diagonalDna2.toString());
            }
        }

        return analyzeDna(dnaSequences) >= 3;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    private int analyzeDna(ArrayList<String> dnaSequences) {
        final String[] mutantDnaSequences = { "AAAA", "CCCC", "GGGG", "TTTT" };
        int mutantDnaOcurrencies = 0;

        for (String dnaSequence : dnaSequences) {
            for (String mutantDnaSequence : mutantDnaSequences) {
                if (dnaSequence.contains(mutantDnaSequence))
                    mutantDnaOcurrencies++;
            }
        }

        return mutantDnaOcurrencies;
    }
}
