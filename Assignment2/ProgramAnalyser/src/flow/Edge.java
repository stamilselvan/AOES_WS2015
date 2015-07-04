package flow;

public class Edge {
	// an edge simply consists of a source and a target label
	int source;
	int target;
	
	public Edge(int s, int t){
		source = s;
		target = t;
	}
	
	// reverse an edge
	// returns a new edge; this one is not changed
	public Edge reversed(){
		return new Edge(target,source);
	}
	
	public String toString(){
		return "(" + source + "," + target + ")";
	}
	
	public int getSource() {
		return source;
	}

	public int getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + source;
		result = prime * result + target;
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
		Edge other = (Edge) obj;
		if (source != other.source)
			return false;
		if (target != other.target)
			return false;
		return true;
	}
	
	
	
}
