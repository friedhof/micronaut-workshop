package ch.jug.micronaut.beers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Beer {

    private final Long id;

    private final String name;

    private final String brewery;

    @JsonCreator
    public Beer(@JsonProperty("id") final Long id,
                @JsonProperty("name") final String name,
                @JsonProperty("brewery") final String brewery) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
    } 

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrewery() {
        return brewery;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brewery == null) ? 0 : brewery.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Beer other = (Beer) obj;
        if (brewery == null) {
            if (other.brewery != null)
                return false;
        } else if (!brewery.equals(other.brewery))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Beer [id=" + id + ", name=" + name + ", brewery=" + brewery + "]";
    }

}
