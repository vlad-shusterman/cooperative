import api from '../../../api/api'

export default {
  fetchOwners() {
    return api().get('owners')
  },

  fetchOwnerCommunications(personID) {
    return api().get(`communication/person/${personID}`)
  },

  addCommunications(personID, body) {
    return api().post(`communication`, body)
  }
}
