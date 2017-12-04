package problemset1;

public class HashChecker {
  
  public HashChecker(String hashIdentifier) {
    this.hashIdentifier = hashIdentifier ;
  }
  
  private String hashIdentifier ;

  public String getHashIdentifier() {
    return hashIdentifier;
  }

  public void setHashIdentifier(String hashIdentifier) {
    this.hashIdentifier = hashIdentifier;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hashIdentifier == null) ? 0 : hashIdentifier.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HashChecker other = (HashChecker) obj;
    if (hashIdentifier == null) {
      if (other.hashIdentifier != null)
        return false;
    } else if (!hashIdentifier.equals(other.hashIdentifier))
      return false;
    return true;
  }
  

}
