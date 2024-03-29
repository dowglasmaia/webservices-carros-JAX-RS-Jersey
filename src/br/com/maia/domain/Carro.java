package br.com.maia.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String tipo;

	private String nome;

	private String desc;

	private String urlFoto;

	private String urlVideo;

	private String latitude;

	private String longitude;

	public Carro() {
		// TODO Auto-generated constructor stub
	}

	public Carro(Long id, String tipo, String nome, String desc, String urlFoto, String urlVideo, String latitude,
			String longitude) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.desc = desc;
		this.urlFoto = urlFoto;
		this.urlVideo = urlVideo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro[id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", desc=" + desc + ", urlForo=" + urlFoto
				+ ", urlVideo=" + urlVideo + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
