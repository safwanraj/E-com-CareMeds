/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author safwan
 */
@Entity
@Table(name = "rolepermission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolepermission.findAll", query = "SELECT r FROM Rolepermission r"),
    @NamedQuery(name = "Rolepermission.findByRolePermissionId", query = "SELECT r FROM Rolepermission r WHERE r.rolePermissionId = :rolePermissionId")})
public class Rolepermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RolePermissionId")
    private Integer rolePermissionId;
    @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId")
    @ManyToOne(optional = false)
    private Permission permissionId;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne(optional = false)
    private Roles roleId;

    public Rolepermission() {
    }

    public Rolepermission(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePermissionId != null ? rolePermissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolepermission)) {
            return false;
        }
        Rolepermission other = (Rolepermission) object;
        if ((this.rolePermissionId == null && other.rolePermissionId != null) || (this.rolePermissionId != null && !this.rolePermissionId.equals(other.rolePermissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rolepermission[ rolePermissionId=" + rolePermissionId + " ]";
    }
    
}
