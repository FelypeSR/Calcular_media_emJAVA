public class metodos implements visualapp {
    private String nome;
    private String cpf;
    private String turma;
    private float[] notas;

    public metodos(String nome, String cpf, String turma, float[] notas) {
        this.nome = nome;
        this.cpf = cpf;
        this.turma = turma;
        this.notas = notas;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getTurma() {
        return turma;
    }

    @Override
    public float calcularMedia() {
        float soma = 0;
        for (float nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    @Override
    public String getSituacao() {
        float media = calcularMedia();
        return media < 7 ? "Reprovado" : "Aprovado";
    }
}
    

