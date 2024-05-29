import java.util.List;
import java.util.ArrayList;

public class GestaoFamiliares {
    private List<Familiar> familiares;

    public GestaoFamiliares() {
        this.familiares = new ArrayList<>();
    }

    public void adicionarFamiliar(Familiar familiar) {
        familiares.add(familiar);
    }

    public List<Familiar> getFamilia() {
        return familiares;
    }

    public void setFamilia(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public void adicionarFamiliares(List<Familiar> novosFamiliares) {
        familiares.addAll(novosFamiliares);
    }
}
