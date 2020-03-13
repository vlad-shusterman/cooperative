import api from '../../../api/api'

export default {
  fetchProperties() {
    return api().get('property')
  },
  addProperty(property) {
    return api().post('property', property)
  },
  // getPropertyOwner(ownerID) {
  //
  // }
}
