package org.ismaelviss.userSearch.cli;

import com.beust.jcommander.Parameter;


public class CLIArguments {
    CLIArguments() {

    }

    @Parameter(
            required = false,
            descriptionKey = "KEYWORD",
            description = "filter de la lista",
            validateWith = CLIKeywordValidator.class
    )
    private String keyword;

    @Parameter(
            names = {"--limit", "-l"},
            required = false,
            descriptionKey = "LIMIT",
            description = "limite de la lista"
            //validateWith = CLILimitValidator.class
    )
    private Integer limit = 10;

    @Parameter(
            names = {"--help", "-h"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostar ayuda"
    )
    private boolean isHelp;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public void setHelp(boolean help) {
        isHelp = help;
    }







    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CLIArguments)) return false;

        CLIArguments that = (CLIArguments) o;

        if (isHelp() != that.isHelp()) return false;
        if (getLimit() != null ? !getLimit().equals(that.getLimit()) : that.getLimit() != null) return false;
        return getKeyword() != null ? getKeyword().equals(that.getKeyword()) : that.getKeyword() == null;
    }

    @Override
    public int hashCode() {
        int result = getLimit() != null ? getLimit().hashCode() : 0;
        result = 31 * result + (getKeyword() != null ? getKeyword().hashCode() : 0);
        result = 31 * result + (isHelp() ? 1 : 0);
        return result;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "limit=" + limit +
                ", keyword=" + keyword +
                ", isHelp=" + isHelp +
                '}';
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
